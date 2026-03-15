package com.finance.common.reference.service;

import com.finance.common.reference.dto.Issuer.*;
import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.Issuer;
import com.finance.common.reference.mapper.IssuerMapper;
import com.finance.common.reference.repository.CountryRepository;
import com.finance.common.reference.repository.IssuerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IssuerService {

    private final IssuerRepository issuerRepository;
    private final CountryRepository countryRepository;
    private final IssuerMapper mapper;

    private Issuer getEntity(Long id)
    {
        return issuerRepository.findById(id).orElseThrow();
    }

    @Transactional
    public CreateIssuerResponse create(CreateIssuerRequest request) {
        Issuer entity = mapper.toEntity(request);
        Issuer saved = issuerRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetIssuerResponse get(Long id) {
        Issuer entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetIssuerAllResponse getAll(Boolean active) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<Issuer> countries = (active == null)
                ? issuerRepository.findAll(sort)
                : issuerRepository.findAllByActive(active, sort);
        List<GetIssuerResponse> items = mapper.toGetResponseList(countries);
        return new GetIssuerAllResponse(items);
    }

    @Transactional
    public UpdateIssuerResponse update(Long id, UpdateIssuerRequest request) {
        Issuer entity = getEntity(id);
        Country country = null;
        if (request.countryId() != null) {
            country = getCountryOrNull(request.countryId());
        }
        Issuer parentIssuer = null;
        if (request.parentIssuerId() != null) {
            if (id.equals(request.parentIssuerId())) {
                throw new IllegalArgumentException("issuer는 자기 자신을 parentIssuer로 가질 수 없습니다.");
            }
            parentIssuer = getIssuerOrNull(request.parentIssuerId());
            validateNoCircularParent(id, parentIssuer);
        }
        entity.update(
                request.issuerCode(),
                request.name(),
                country,
                request.lei(),
                parentIssuer,
                request.groupFlag(),
                request.active(),
                request.description()
        );
        Issuer saved = issuerRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutIssuerResponse put(Long id, PutIssuerRequest request) {
        Issuer entity = getEntity(id);
        Country country = null;
        if (request.countryId() != null) {
            country = getCountryOrNull(request.countryId());
        }
        Issuer parentIssuer = null;
        if (request.parentIssuerId() != null) {
            if (id.equals(request.parentIssuerId())) {
                throw new IllegalArgumentException("issuer는 자기 자신을 parentIssuer로 가질 수 없습니다.");
            }
            parentIssuer = getIssuerOrNull(request.parentIssuerId());
            validateNoCircularParent(id, parentIssuer);
        }
        entity.update(
                request.issuerCode(),
                request.name(),
                country,
                request.lei(),
                parentIssuer,
                request.groupFlag(),
                request.active(),
                request.description()
        );
        Issuer saved = issuerRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteIssuerResponse delete(Long id) {
        boolean exists = issuerRepository.existsById(id);
        if (exists) {
            issuerRepository.deleteById(id);
        }
        return new DeleteIssuerResponse(id, exists);
    }


    private Country getCountryOrNull(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found. id=" + countryId));
    }

    private Issuer getIssuerOrNull(Long issuerId) {
        return issuerRepository.findById(issuerId)
                .orElseThrow(() -> new EntityNotFoundException("Parent issuer not found. id=" + issuerId));
    }

    private void validateNoCircularParent(Long issuerId, Issuer parentIssuer) {
        Issuer current = parentIssuer;
        while (current != null) {
            if (issuerId.equals(current.getId())) {
                throw new IllegalArgumentException("parentIssuer 순환 참조는 허용되지 않습니다.");
            }
            current = current.getParentIssuer();
        }
    }
}
