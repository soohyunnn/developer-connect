package com.connect.developer.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id
    private String authorityName;

}
