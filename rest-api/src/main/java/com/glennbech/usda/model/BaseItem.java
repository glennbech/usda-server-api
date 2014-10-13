package com.glennbech.usda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 *
 */

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class BaseItem {

}
