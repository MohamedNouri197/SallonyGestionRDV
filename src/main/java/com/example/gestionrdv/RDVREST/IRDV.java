package com.example.gestionrdv.RDVREST;

import java.util.List;

public interface IRDV {


    public List<RDV> gelallRDVs();
    public RDV saveRDV(RDV RDV);
    public RDV deleteRDV(int id);
    public RDV updateRDV(RDV RDV);
    public RDV getRDVById(int id);

}
