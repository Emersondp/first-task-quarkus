package org.acme;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Pack extends PanacheEntity{

    public BigDecimal codPack;
        
    public String sendName;

    public String recepName;

    public String originAdress;

    public String destinyAdress;

    @CreationTimestamp
    public Date dataAtual;

    @UpdateTimestamp
    public Date dataCriacao;

    public Boolean deleted;
    
}
