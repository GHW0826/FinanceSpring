package com.finance.common.reference.service;

import com.finance.common.reference.dto.country.*;
import com.finance.common.reference.entity.Country;
import com.finance.common.reference.entity.Vendor;
import com.finance.common.reference.mapper.VendorMapper;
import com.finance.common.reference.repository.VendorRepository;
import com.finance.common.enums.VendorStatus;
import com.finance.common.reference.dto.vendor.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper mapper;

    private Vendor getEntity(Long id)
    {
        return vendorRepository.findById(id).orElseThrow();
    }

    @Transactional
    public CreateVendorResponse create(CreateVendorRequest request) {
        Vendor entity = mapper.toEntity(request);
        Vendor saved = vendorRepository.save(entity);
        return mapper.toCreateResponse(saved);
    }

    public GetVendorResponse get(Long id) {
        Vendor entity = getEntity(id);
        return mapper.toGetResponse(entity);
    }

    public GetVendorAllResponse getAll(Boolean active) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<Vendor> countries = (active == null)
                ? vendorRepository.findAll(sort)
                : vendorRepository.findAllByActive(active, sort);
        List<GetVendorResponse> items = mapper.toGetResponseList(countries);
        return new GetVendorAllResponse(items);
    }

    @Transactional
    public UpdateVendorResponse update(Long id, UpdateVendorRequest request) {
        Vendor entity = getEntity(id);
        entity.update(
                request.vendorCode(),
                request.name(),
                request.homepageUrl(),
                request.active(),
                request.description()
        );
        Vendor saved = vendorRepository.save(entity);
        return mapper.toUpdateResponse(saved);
    }

    @Transactional
    public PutVendorResponse put(Long id, PutVendorRequest request) {
        Vendor entity = getEntity(id);
        entity.update(
                request.vendorCode(),
                request.name(),
                request.homepageUrl(),
                request.active(),
                request.description()
        );
        Vendor saved = vendorRepository.save(entity);
        return mapper.toPutResponse(saved);
    }

    @Transactional
    public DeleteVendorResponse delete(Long id) {
        boolean exists = vendorRepository.existsById(id);
        if (exists) {
            vendorRepository.deleteById(id);
        }
        return new DeleteVendorResponse(id, exists);
    }
}