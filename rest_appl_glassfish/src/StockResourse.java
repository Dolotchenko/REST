import javax.ws.rs.*;

@Path("/test")
public class StockResourse {
    //Dat dat=new Dat();

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
   // @Path("{symbol}")
    @Produces("application/json")

    public CustomPerson getPerson(@QueryParam("symbol") String symb, @QueryParam("page") int page,
                                  @QueryParam("start") int start, @QueryParam("limit") int limit ) {

        Dat dat= new Dat();
        dat.dataFromFile();
        if (symb.isEmpty()) {

            CustomPerson customPerson1 = new CustomPerson(dat.returnAllPersons().size(),dat.returnAllPersonsPagination(page, start, limit));
            return customPerson1;
        }
       else {
           CustomPerson customPerson2 = new CustomPerson(dat.returnFindPerson(symb).size(),dat.returnFindPersonPagination(symb,page, start, limit));
            return customPerson2;
       }

    }

}
