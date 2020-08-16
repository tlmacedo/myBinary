package br.com.tlmacedo.binary.model;

import br.com.tlmacedo.binary.model.Enums.MSG_TYPE;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Msg_type {

    private ObjectProperty<MSG_TYPE> msg_type = new SimpleObjectProperty<>();

    public Msg_type() {
    }

    public Msg_type(String strMsgType) {
        this.msg_typeProperty().setValue(MSG_TYPE.valueOf(strMsgType.toUpperCase()));
    }

    public MSG_TYPE getMsg_type() {
        return msg_type.get();
    }

    public ObjectProperty<MSG_TYPE> msg_typeProperty() {
        return msg_type;
    }

    public void setMsg_type(MSG_TYPE msg_type) {
        this.msg_type.set(msg_type);
    }

    @Override
    public String toString() {
        return "Msg_type{" +
                "msg_type=" + msg_type +
                '}';
    }
}
