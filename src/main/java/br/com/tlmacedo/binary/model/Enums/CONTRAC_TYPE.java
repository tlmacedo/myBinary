package br.com.tlmacedo.binary.model.Enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum CONTRAC_TYPE {
    MULTUP (0, "MULTUP"),
    MULTDOWN (1, ""),
    UPORDOWN (2, ""),
    EXPIRYRANGE (3, ""),
    ONETOUCH (4, ""),
    CALLE (5, ""),
    LBHIGHLOW (6, ""),
    ASIAND (7, ""),
    EXPIRYRANGEE (8, ""),
    DIGITDIFF (9, ""),
    DIGITMATCH (10, ""),
    DIGITOVER (11, ""),
    PUTE (12, ""),
    DIGITUNDER (13, ""),
    NOTOUCH (14, ""),
    CALL (15, ""),
    RANGE (16, ""),
    LBFLOATPUT (17, ""),
    DIGITODD (18, ""),
    PUT (19, ""),
    ASIANU (20, ""),
    LBFLOATCALL (21, ""),
    EXPIRYMISSE (22, ""),
    EXPIRYMISS (23, ""),
    DIGITEVEN (24, ""),
    TICKHIGH (25, ""),
    TICKLOW (26, ""),
    RESETCALL (27, ""),
    RESETPUT (28, ""),
    CALLSPREAD (29, ""),
    PUTSPREAD (30, ""),
    RUNHIGH (31, ""),
    RUNLOW(32, "");

    private Integer cod;
    private String descricao;

    private CONTRAC_TYPE(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }


    public static List<CONTRAC_TYPE> getList() {
        List list = Arrays.asList(CONTRAC_TYPE.values());
        Collections.sort(list, new Comparator<CONTRAC_TYPE>() {
            @Override
            public int compare(CONTRAC_TYPE e1, CONTRAC_TYPE e2) {
                return e1.getDescricao().compareTo(e2.getDescricao());
            }
        });
        return list;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }

}
