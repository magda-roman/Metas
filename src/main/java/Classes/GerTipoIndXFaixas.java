/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author edumokfa
 */
@Entity
@Table(name = "GER_TIPO_INDIXFAIXAS")
public class GerTipoIndXFaixas implements Serializable {
    
    @Id
    @SequenceGenerator(name = "GEN_GER_TIPO_INDXFAIXAS", sequenceName = "GEN_GER_TIPO_INDXFAIXAS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_GER_TIPO_INDXFAIXAS")
    @Column(name = "TPF_COD")
    private Integer tpfCod;
    @NotNull
    @JoinColumn(name = "TPF_COD_TIPO", referencedColumnName = "TPI_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private GerTipoIndicadores tpfCodTipo;
    @NotNull
    @Column(name = "TPF_SEQ")
    private Integer tpfSeq;
    @Column(name = "TPF_FAIXA_INI")
    private Double tpfFaixaIni;
    @Column(name = "TPF_FAIXA_FIM")
    private Double tpfFaixaFim;
    @Column(name = "TPF_PERC_PREMIACAO")
    private Double tpfPercPremiacao;
    

    public GerTipoIndXFaixas() {
    }

    public Integer getTpfCod() {
        return tpfCod;
    }

    public void setTpfCod(Integer tpfCod) {
        this.tpfCod = tpfCod;
    }

    public GerTipoIndicadores getTpfCodTipo() {
        return tpfCodTipo;
    }

    public void setTpfCodTipo(GerTipoIndicadores tpfCodTipo) {
        this.tpfCodTipo = tpfCodTipo;
    }

    public Integer getTpfSeq() {
        return tpfSeq;
    }

    public void setTpfSeq(Integer tpfSeq) {
        this.tpfSeq = tpfSeq;
    }

    public Double getTpfFaixaIni() {
        return tpfFaixaIni;
    }

    public void setTpfFaixaIni(Double tpfFaixaIni) {
        this.tpfFaixaIni = tpfFaixaIni;
    }

    public Double getTpfFaixaFim() {
        return tpfFaixaFim;
    }

    public void setTpfFaixaFim(Double tpfFaixaFim) {
        this.tpfFaixaFim = tpfFaixaFim;
    }

    public Double getTpfPercPremiacao() {
        return tpfPercPremiacao;
    }

    public void setTpfPercPremiacao(Double tpfPercPremiacao) {
        this.tpfPercPremiacao = tpfPercPremiacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.tpfCod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GerTipoIndXFaixas other = (GerTipoIndXFaixas) obj;
        return Objects.equals(this.tpfCod, other.tpfCod);
    }
    
    
        
}
