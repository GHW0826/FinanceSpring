package com.finance.common.reference.mapper;

import com.finance.common.reference.entity.Vendor;
import com.finance.common.reference.dto.vendor.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Vendor toEntity(CreateVendorRequest req);

    @Mapping(target = "vendorId", source = "id")
    CreateVendorResponse toCreateResponse(Vendor e);

    @Mapping(target = "vendorId", source = "id")
    UpdateVendorResponse toUpdateResponse(Vendor e);

    @Mapping(target = "vendorId", source = "id")
    GetVendorResponse toGetResponse(Vendor e);

    @Mapping(target = "vendorId", source = "id")
    PutVendorResponse toPutResponse(Vendor e);

    List<GetVendorResponse> toGetResponseList(List<Vendor> entities);
}
