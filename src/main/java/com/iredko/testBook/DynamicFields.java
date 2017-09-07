package com.iredko.testBook;

import java.sql.Struct;
import java.util.NoSuchElementException;

/**
 * Created by IRedko on 06.09.2017.
 */
public class DynamicFields {

    private Object[][] fields;

    public DynamicFields(int initialSize){
        fields = new Object[initialSize][2];
        for(int i=0;i<initialSize;i++){
            fields[i] = new Object[]{null,null};
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Object[] obj:fields){
            result.append(obj[0]);
            result.append(";");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id){
        for (int i=0; i<fields.length;i++) {
            if (id.equals(fields[i][0])) {
                return 0;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchElementException{
        int fieldNum = hasField(id);
        if(fieldNum==-1){
            throw new NoSuchElementException();
        }
        return fieldNum;
    }

    private int makeField(String id){
        for(int i=0;i<fields.length;i++){
            if(fields[i][0]==null){
                fields[i][0]=id;
                return i;
            }
        }
        Object[][]tmp=new Object[fields.length+1][2];
        for(int i=0;i<fields.length;i++){
            tmp[i]=fields[i];
        }
        for (int i=fields.length;i<tmp.length;i++){
            tmp[i]=new Object[]{null,null};
        }
        fields=tmp;
        return makeField(id);
    }

    public Object setField(String id, Object value) throws DynamicFieldsException{
        if(value==null){
            DynamicFieldsException dfe=new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber=hasField(id);
        if(fieldNumber==-1){
            fieldNumber=makeField(id);
        }
        Object result = null;

        try{
            result = getFieldNumber(id);
        }catch (NoSuchElementException e){
            throw new RuntimeException();
        }
        fields[fieldNumber][1]=value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try{
            df.setField("d","Значение d");
            df.setField("число",47);
            df.setField("число2",48);
            System.out.println(df);
            df.setField("d","Новое значение d");
            df.setField("число 3",11);
            System.out.println("df:"+df);
            System.out.println("df.getFieldNumber(\"d\")   " + df.getFieldNumber("d"));
            Object field = df.setField("d",null);
        }catch (NoSuchElementException e){
            e.printStackTrace(System.out);
        }catch (DynamicFieldsException e){
            e.printStackTrace();
        }
    }


}
