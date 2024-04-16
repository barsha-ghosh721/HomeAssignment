package dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductMetaDataRequestDTO {

    private List<ProductMetadataDTO> productMetadataList;
}

