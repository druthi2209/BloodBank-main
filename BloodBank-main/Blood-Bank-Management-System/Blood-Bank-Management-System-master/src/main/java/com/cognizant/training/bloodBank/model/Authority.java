package com.cognizant.training.bloodBank.model;

import com.cognizant.training.bloodBank.model.Donor;
import com.cognizant.training.bloodBank.model.Seeker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
@Builder
public class Authority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "donorid")
    private Donor donor;
    @ManyToOne
    @JoinColumn(name = "seekerid")
    private Seeker seeker;

}