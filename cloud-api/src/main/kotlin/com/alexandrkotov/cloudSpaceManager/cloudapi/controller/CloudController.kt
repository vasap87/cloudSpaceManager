package com.alexandrkotov.cloudSpaceManager.cloudapi.controller

import com.alexandrkotov.cloudSpaceManager.cloudapi.model.Cloud
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cloud")
class CloudController {

    @GetMapping
    fun getCloudsInfo() = Cloud("Yandex Disk", 500_000_000, 500_000_000)
}