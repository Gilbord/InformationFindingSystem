package com.gilbord.Web

import com.gilbord.Entities.Drug
import com.gilbord.Repository.DrugRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DrugController {

    @Autowired
    lateinit var drugRepository: DrugRepository

    @CrossOrigin
    @RequestMapping(value = "/drug",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun addDrug(@RequestBody drug: Drug): ResponseEntity<Drug> =
            ResponseEntity(this.drugRepository.save(drug), HttpStatus.OK)

    @CrossOrigin
    @RequestMapping(value = "/drug/id/{id}",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getDrugByID(@PathVariable drugId: Long): ResponseEntity<Drug> {
        val drug = this.drugRepository.findOne(drugId)
        return if (drug != null) {
            ResponseEntity(drug, HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/drug",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getAllDrugs(): ResponseEntity<List<Drug>> {
        val drug = this.drugRepository.findAll()
        return if (!drug.isEmpty()) {
            ResponseEntity(drug.toMutableList(), HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @RequestMapping(value = "/drug/partOfName/{partOfName}",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getAllDrugsByPartOfName(@PathVariable("partOfName") partOfName: String): ResponseEntity<List<Drug>> {
        val drug = this.drugRepository.findAllDrugsByPartOfName(partOfName)
        return if (drug.isEmpty()) {
            ResponseEntity(drug, HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

}