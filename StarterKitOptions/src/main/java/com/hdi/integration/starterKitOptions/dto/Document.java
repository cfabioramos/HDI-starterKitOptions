package com.hdi.integration.starterKitOptions.dto;

import java.io.Serializable;

public class Document implements Serializable {

    public Document(String documento){
        this.dsEntradaLst2Via = new DsEntradaLst2Via(documento);
    }

    private DsEntradaLst2Via dsEntradaLst2Via;

    public DsEntradaLst2Via getDsEntradaLst2Via() {
        return dsEntradaLst2Via;
    }

    public void setDsEntradaLst2Via(DsEntradaLst2Via dsEntradaLst2Via) {
        this.dsEntradaLst2Via = dsEntradaLst2Via;
    }

    private class DsEntradaLst2Via {

        public DsEntradaLst2Via(String documento) {
            this.ttEntradaLst2Via = new TtEntradaLst2Via(documento);
        }

        private TtEntradaLst2Via ttEntradaLst2Via;

        public TtEntradaLst2Via getTtEntradaLst2Via() {
            return ttEntradaLst2Via;
        }

        public void setTtEntradaLst2Via(TtEntradaLst2Via ttEntradaLst2Via) {
            this.ttEntradaLst2Via = ttEntradaLst2Via;
        }
    }

    private class TtEntradaLst2Via {

        public TtEntradaLst2Via(String documento) {
            this.documento = documento;
        }

        private String documento;

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }
    }
}
