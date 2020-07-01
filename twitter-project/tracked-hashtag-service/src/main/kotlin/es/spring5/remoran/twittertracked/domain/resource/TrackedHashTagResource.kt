package es.spring5.remoran.twittertracked.domain.resource

import es.spring5.remoran.twittertracked.domain.TrackedHashTag
import es.spring5.remoran.twittertracked.domain.service.TrackedHashTagService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tracked-hash-tag")
class TrackedHashTagResource(private val service:TrackedHashTagService) {

    @GetMapping
    fun all() = this.service.all();

    @PostMapping
    fun save(@RequestBody hashTag:TrackedHashTag) = this.service.save(hashTag)

}