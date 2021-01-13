package be.heh.app.mappers.app;

import be.heh.app.model.facades.app.ParapageFacade;
import be.heh.app.model.facades.app.ParatagFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParapageMapper {

    @Autowired
    ParapageFacade parapageFacade;

}
