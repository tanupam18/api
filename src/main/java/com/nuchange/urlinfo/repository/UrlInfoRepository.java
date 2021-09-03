package com.nuchange.urlinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuchange.urlinfo.model.UrlInfo;

@Repository
public interface UrlInfoRepository extends JpaRepository<UrlInfo, Long>
 {
	UrlInfo findByUrl(String url);
}

