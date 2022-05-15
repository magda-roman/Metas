package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "MOV_INDICADORES")
public class MovIndicadores implements Serializable {

    @Id
    @SequenceGenerator(name = "GEN_MOV_INDICADORES", sequenceName = "GEN_MOV_INDICADORES", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_MOV_INDICADORES")
    @Column(name = "MOV_COD")
    private Integer movCod;
    @NotNull
    @Column(name = "MOV_DTHR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date movDtHr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mviCodIndi", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MovIndXTipos> movIndXTipos = new ArrayList<>();

    public MovIndicadores() {
    }

    public Integer getMovCod() {
        return movCod;
    }

    public void setMovCod(Integer movCod) {
        this.movCod = movCod;
    }

    public Date getMovDtHr() {
        return movDtHr;
    }

    public void setMovDtHr(Date movDtHr) {
        this.movDtHr = movDtHr;
    }

    public List<MovIndXTipos> getMovIndXTipos() {
        return movIndXTipos;
    }

    public void setMovIndXTipos(List<MovIndXTipos> movIndXTipos) {
        this.movIndXTipos = movIndXTipos;
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
        final MovIndicadores other = (MovIndicadores) obj;
        return Objects.equals(this.movCod, other.movCod);
    }

}
