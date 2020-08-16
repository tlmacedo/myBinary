package br.com.tlmacedo.binary.model.Enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum MSG_TYPE {

    TICK(1, "tick");


    private Integer cod;
    private String descricao;

    private MSG_TYPE(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }


    public static List<MSG_TYPE> getList() {
        List list = Arrays.asList(MSG_TYPE.values());
        Collections.sort(list, new Comparator<MSG_TYPE>() {
            @Override
            public int compare(MSG_TYPE e1, MSG_TYPE e2) {
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
