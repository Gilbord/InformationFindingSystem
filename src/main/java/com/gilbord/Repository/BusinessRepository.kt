package com.gilbord.Repository

import com.gilbord.Entities.Business
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BusinessRepository: JpaRepository<Business, Long>