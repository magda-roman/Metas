/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.Serializable;
import java.util.Collection;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author edumokfa
 */
public class ListUtil implements Serializable {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(LazyDataModel model) {
        return model == null || model.getRowCount() == 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isSizeOne(Collection list) {
        return (isNotEmpty(list) && list.size() == 1);
    }
}
