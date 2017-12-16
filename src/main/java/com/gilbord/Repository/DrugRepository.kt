package com.gilbord.Repository

import com.gilbord.Entities.Drug
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DrugRepository : JpaRepository<Drug, Long> {

    @Query("select * from DRUG d where d.drug_name like %?1%", nativeQuery = true)
    open fun findAllDrugsByPartOfName(partOfName: String): List<Drug>

}