package com.projekat.poslovna.service.exception;

import com.projekat.poslovna.controller.exception.CustomException;

/**
 * Created by milan.miljus on 9/1/19 4:31 PM.
 */
public class CantTransferWithinSameWarehouseException extends CustomException {

    public CantTransferWithinSameWarehouseException() {
        super("Cant transfer within same warehouse!!!");
    }

}
