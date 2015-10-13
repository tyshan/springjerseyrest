package cn.tyshan.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.tyshan.rest.model.Campaign;

@Repository
public interface CampaignRepository extends PagingAndSortingRepository<Campaign, Long> {

}
