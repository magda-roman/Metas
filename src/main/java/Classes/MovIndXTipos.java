package Classes;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "MOV_INDXTIPOS")
public class MovIndXTipos implements Serializable {

    @Id
    @SequenceGenerator(name = "GEN_MOV_INDXTIPOS", sequenceName = "GEN_MOV_INDXTIPOS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_MOV_INDXTIPOS")
    @Column(name = "MVI_COD")
    private Integer movCod;
    @NotNull
    @JoinColumn(name = "MVI_COD_TIPO", referencedColumnName = "TPI_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private GerTipoIndicadores mviCodTipo;
    @NotNull
    @JoinColumn(name = "MVI_COD_INDI", referencedColumnName = "MOV_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private MovIndicadores mviCodIndi;
    @Column(name = "MVI_VLR_RESULTADO")
    private Double mviVlrResultado;
    @Column(name = "MVI_PERC_CALCULADO")
    private Double mviPercCalculado;
    

    public MovIndXTipos() {
    }

    public Integer getMovCod() {
        return movCod;
    }

    public void setMovCod(Integer movCod) {
        this.movCod = movCod;
    }

    public GerTipoIndicadores getMviCodTipo() {
        return mviCodTipo;
    }

    public void setMviCodTipo(GerTipoIndicadores mviCodTipo) {
        this.mviCodTipo = mviCodTipo;
    }

    public MovIndicadores getMviCodIndi() {
        return mviCodIndi;
    }

    public void setMviCodIndi(MovIndicadores mviCodIndi) {
        this.mviCodIndi = mviCodIndi;
    }

    public Double getMviVlrResultado() {
        return mviVlrResultado;
    }

    public void setMviVlrResultado(Double mviVlrResultado) {
        this.mviVlrResultado = mviVlrResultado;
    }

    public Double getMviPercCalculado() {
        return mviPercCalculado;
    }

    public void setMviPercCalculado(Double mviPercCalculado) {
        this.mviPercCalculado = mviPercCalculado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.movCod);
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
        final MovIndXTipos other = (MovIndXTipos) obj;
        return Objects.equals(this.movCod, other.movCod);
    }
}
