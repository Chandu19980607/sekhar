package com.kishore.sekhar.serviceimpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kishore.sekhar.model.BuildingBlocksEntity;
import com.kishore.sekhar.model.BuildingBlocksReqBody;
import com.kishore.sekhar.model.BuildingBlocksReqBody.BuildingBlock;
import com.kishore.sekhar.model.BuildingDetailsFloorsEntity;
import com.kishore.sekhar.repository.BuildingBlockRepository;
import com.kishore.sekhar.repository.BuildingDetailsFloorsEntityRepository;
import com.kishore.sekhar.service.BuildingBlockService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class BuildingBlockServiceImpl implements BuildingBlockService {

    @Autowired
    private BuildingBlockRepository buildingrepository;

    @Autowired
    private BuildingDetailsFloorsEntityRepository buildingFloorsRepository;

    @Autowired
    private HttpServletRequest request;

    @Transactional
    @Override
    public ResponseEntity<?> saveBuildingBlockDetails(BuildingBlocksReqBody reqBody) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            String ac_year = reqBody.getAc_year();
            Integer coll_code = reqBody.getColl_code();

            // Save Building Blocks
            List<BuildingBlocksEntity> blocks = new ArrayList<>();
            for (BuildingBlock blockReq : reqBody.getBuildingblocks()) {
                BuildingBlocksEntity blockEntity = new BuildingBlocksEntity();
                blockEntity.setColl_code(coll_code);
                blockEntity.setAc_year(ac_year);
                blockEntity.setBuild_block_name(blockReq.getBuild_block_name());
                blockEntity.setSl_no(blockReq.getBlock_no());
                blockEntity.setBlock_no(blockReq.getBlock_no());
                blockEntity.setCampus_type(blockReq.getCampus_type());
                blockEntity.setNo_of_floors((blockReq.getNo_of_floors()));
                blockEntity.setBuildingimg(blockReq.getBuildingimg());
                blockEntity.setCreated_by(coll_code.toString());
                blockEntity.setCreated_ip(request.getRemoteAddr());

                blocks.add(blockEntity);
            }
            buildingrepository.saveAll(blocks);

            // Save Floors for each building block
            List<BuildingDetailsFloorsEntity> floors = new ArrayList<>();
            for (BuildingBlock blockReq : reqBody.getBuildingblocks()) {
                // Ensure the number of site areas matches the number of floors
                List<Float> siteAreas = blockReq.getSiteArea();
                int noOfFloors = (blockReq.getNo_of_floors());
                if (siteAreas.size() != noOfFloors) {
                    throw new IllegalArgumentException("The number of site areas must match the number of floors for block: " + blockReq.getBuild_block_name());
                }

                for (int i = 0; i < noOfFloors; i++) {
                    BuildingDetailsFloorsEntity floorEntity = new BuildingDetailsFloorsEntity();
                    floorEntity.setColl_code(coll_code);
                    floorEntity.setAc_year(ac_year);
                    floorEntity.setBlock_slno(blockReq.getBlock_no());
                    floorEntity.setFloor_no(i + 1);  // Floor numbering starts from 1
                    floorEntity.setSite_area(siteAreas.get(i));  // Get the corresponding site area for the floor
                    floorEntity.setIp_address(request.getRemoteAddr());

                    floors.add(floorEntity);
                }
            }
            buildingFloorsRepository.saveAll(floors);

            response.put("scode", "01");
            response.put("sdesc", "Successfully Submitted");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.put("scode", "02");
            response.put("sdesc", "Validation Error: " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.put("scode", "03");
            response.put("sdesc", "Insertion Failure: " + e.getLocalizedMessage());
        }
        return ResponseEntity.ok(response);
    }
}
