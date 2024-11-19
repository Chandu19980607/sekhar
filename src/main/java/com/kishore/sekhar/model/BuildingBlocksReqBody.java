package com.kishore.sekhar.model;


import lombok.Data;
import java.util.List;

@Data
public class BuildingBlocksReqBody {

    private Integer coll_code;
    private String ac_year;
    private List<BuildingBlock> buildingblocks;
    private Float instructional_area;
    private Float admin_area;
    private Float amenities_area;
    private Float access_circul_area;

    @Data
    public static class BuildingBlock {
        private String build_block_name;
        private Integer block_no;
        private Integer no_of_floors;
        private String buildingimg;
        private String campus_type;
        private List<Float> siteArea;
    }
}
