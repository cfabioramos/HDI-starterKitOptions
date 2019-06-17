package com.hdi.integration.starterKitOptions.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PDocument implements Serializable {

    public PDocument(Long nuDocu){
        this.dsEntradaMatImp = new DsEntradaMatImp(nuDocu);
    }

    private DsEntradaMatImp dsEntradaMatImp;

    public DsEntradaMatImp getDsEntradaMatImp() {
        return dsEntradaMatImp;
    }

    private class DsEntradaMatImp {

        public DsEntradaMatImp(Long nuDocu) {
            this.paramEntrada = new ArrayList<>();
            this.paramEntrada.add(new ParamEntrada(nuDocu));
        }

        private List<ParamEntrada> paramEntrada;

        public List<ParamEntrada> getParamEntrada() {
            return paramEntrada;
        }

        public void setParamEntrada(List<ParamEntrada> paramEntrada) {
            this.paramEntrada = paramEntrada;
        }
    }

    private class ParamEntrada {

        public ParamEntrada(Long nuDocu) {
            this.chave_doc = nuDocu;
        }

        private Long chave_doc;

        public Long getChave_doc() {
            return chave_doc;
        }

        public void setChave_doc(Long chave_doc) {
            this.chave_doc = chave_doc;
        }

    }

}
