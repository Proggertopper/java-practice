package tacos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CreditCardNumber;



@Data
@Entity
public class TacoOrder implements Serializable {
   // @NotBlank(message = "DeliveryName is required")
    private String deliveryName;

    //@NotBlank(message = "Street is required")
    private String deliveryStreet;

    //@NotBlank(message = "Cite is required")
    private String deliveryCity;

   // @NotBlank(message = "State is required")
    private String deliveryState;

    //@NotBlank(message = "Zip code is required")
    private String deliveryZip;

    //@CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

   // @Pattern(regexp ="^(0[1-9]|1[0-2])(\\/)([2-9][0-9])$",
        //    message="Must be formatted MM/YY")
    private String ccExpiration;

    //@Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @ManyToOne
    @JsonIgnore
    private User user;


    private final static long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private Date placedAt = new Date() ;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();


    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

}
