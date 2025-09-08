package com.hps.vilanova.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Entity(name = "elegibilidades")
@Table(name = "elegibilidades")
@Getter
@Setter
public class Elegibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "acamado")
    private boolean acamado;

    @Column(name = "domiciliado")
    private boolean domiciliado;

    @Column(name = "ulcera_feridas")
    private boolean ulcera_feridas;

    @Column(name = "acompanhamento_nutricional")
    private boolean acomp_nutricional;

    @Column(name = "nutricao_parenteral")
    private boolean nutricao_parenteral;

    @Column(name = "uso_de_sonda_nasogastrica")
    private boolean sonda_nasogastrica;

    @Column(name = "uso_de_sonda_nasoenteral")
    private boolean sonda_nasoenteral;

    @Column(name = "uso_de_gastrostomia")
    private boolean gastrostomia;

    @Column(name = "uso_de_colostomia")
    private boolean colostomia;

    @Column(name = "uso_de_cistostomia")
    private boolean cistostomia;

    @Column(name = "uso_de_sonda_vesical_de_demora")
    private boolean sonda_vesical;

    @Column(name = "acompanhamento_pre_operatoorio")
    private boolean acomp_pre_operatorio;

    @Column(name = "acompanhamento_pos_opratorio")
    private boolean acomp_pos_operatorio;

    @Column(name = "adaptacao_uso_ortese_protese")
    private boolean adap_uso_ortese_protese;

    @Column(name = "reabilitacao_domiciliar")
    private boolean reab_domiciliar;

    @Column(name = "controle_de_antecoagulacao")
    private boolean controle_antecoagulacao;

    @Column(name = "cuidados_paliativos_oncologico")
    private boolean cuidados_paliat_oncologico;

    @Column(name = "cuidados_paliativos_final_de_vida")
    private  boolean cuidados_paliat_final_vida;

    @Column(name = "oxigenoterapia_domiciliar")
    private boolean oxigenoterapia_domiciliar;

    @Column(name = "uso_de_traqueostomia")
    private boolean traqueostomia;

    @Column(name = "uso_de_aspirador_vias_aerias_para_higiene_bronquica")
    private boolean aspirador_higiene_bronquica;

    @Column(name = "suporte_ventilatorio_nao_invasivo_cpap")
    private boolean suporte_ventilat_nao_invasivo_cpap;

    @Column(name = "suporte_ventilatorio_nao_invasivo_bilevel")
    private boolean suporte_ventilat_nao_invasivo_bilevel;

    @Column(name = "suporte_ventilatorio_invasivo")
    private boolean suporte_ventilat_invasivo;

    @Column(name = "dialise_peritonial")
    private boolean dialise_peritonial;

    @Column(name = "hemodialise")
    private boolean hemodialise;

    @Column(name = "paracentese_toracocenese")
    private boolean paracentese_toracentese;

    @Column(name = "cuidados_multiprofissional")
    private boolean cuidados_multiprofissional;

    @Column(name = "condicoes_cronico-degenerativas_progressivas")
    private boolean cond_cronico_degenerativas_progressivas;


    @Column(name = "descricao_cond_cronico-degenerativas_progressivas")
    private String desc_cdp;




}
