package org.acme;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import java.util.List;
import java.util.Optional;

@Path("packages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PackResource {

    @GET
    public List<Pack> findAll() {
        return Pack.listAll();
    }

    @POST
    @Transactional
    public void findAll(PackDTO dto) {
        Pack p = new Pack();
        p.codPack = dto.codPack;
        p.sendName = dto.sendName;
        p.recepName = dto.recepName;
        p.originAdress = dto.originAdress;
        p.destinyAdress = dto.destinyAdress;
        p.deleted = dto.deleted;
        p.persist();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void findAll(@PathParam("id") Long id, PackDTO dto) {

        Optional<Pack> packOp = Pack.findByIdOptional(id);

        if (packOp.isPresent()) {
            Pack pack = packOp.get();
            pack.codPack = dto.codPack;
            pack.sendName = dto.sendName;
            pack.recepName = dto.recepName;
            pack.originAdress = dto.originAdress;
            pack.destinyAdress = dto.destinyAdress;
            pack.deleted = dto.deleted;
            pack.persist();
        } else {
            throw new NotFoundException();
        }
    }

    @PUT
    @Path("softDelete/{id}")
    @Transactional
    public void softDelete(@PathParam("id") Long id) {

        Optional<Pack> packOp = Pack.findByIdOptional(id);
            
            Pack pack = packOp.get();

            if (packOp.isPresent()) {
                if (pack.deleted == true) {
                    pack.deleted = false;
                    pack.persist();
                } else {
                    pack.deleted = true;
                    pack.persist();
                }
            } else {
                throw new NotFoundException();
            }
            
    }
    
}
