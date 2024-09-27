package com.gavin.james.controller;

import cn.hutool.core.lang.Dict;
import com.gavin.james.property.ApplicationProperty;
import com.gavin.james.property.DeveloperProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author gavin james
 */
@RestController
@RequiredArgsConstructor
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
    }
}
