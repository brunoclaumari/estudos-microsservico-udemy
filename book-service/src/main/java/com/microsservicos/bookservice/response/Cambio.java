package com.microsservicos.bookservice.response;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;   
    
    private String from;   
    
    private String to;    
    
    private BigDecimal conversionFactor;
    
    /*
     * A annotation "@Transient" é para definir que um atributo não será persistido no
     * banco. Essa não é uma boa prática, está sendo feito assim porque no curso
     * o professor passou só para atender a necessidade básica, de ensinar microsserviços.
     * A forma correta seria criar uma classe DTO alusiva a esta entidade, para que as boas 
     * práticas sejam seguidas, para implementações de API Rest. 
     * */
    @Transient
    private Double convertedValue;
    
    @Transient
    private String environment;

    public Cambio() {
    }

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, Double convertedValue,
            String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

        @Override
    public String toString() {
        return "Cambio [id=" + id + ", from=" + from + ", to=" + to + ", conversionFactor=" + conversionFactor
                + ", convertedValue=" + convertedValue + ", environment=" + environment + "]";
    }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Cambio other = (Cambio) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

    
    
}
