package xyz.tonimartinez.workshop.domain.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xyz.tonimartinez.workshop.R;
import xyz.tonimartinez.workshop.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.workshop.domain.model.Android;

/**
 * Created by tonimc on 5/17/17.
 */

public class AndroidsRepositoryImpl implements AndroidsRepository {

    private Map<Integer, Android> repository;

    public AndroidsRepositoryImpl() {
        this.repository = new HashMap<>();

        this.repository.put(1, new Android(1, "Nougat", "7.0 - 7.1.2", R.drawable.nougat, "Android Nougat incluye una característica llamada multi ventana, que permite usar 2 aplicaciones a la vez con la pantalla dividida. Fabricantes como Samsung implementó la multiventana desde el Galaxy S III. Pero ahora es compatible con cualquier dispositivo Android." ));
        this.repository.put(2, new Android(2, "Marshmallow", "6.0–6.0.1", R.drawable.marshaloww, "Android 6.0 Marshmallow introduce un modelo de permisos rediseñado: ahora hay únicamente ocho categorías de permisos, y las aplicaciones ya no conceden automáticamente todos sus permisos específicos en el momento de la instalación. Se utiliza ahora un sistema \"opt-in\", en el que los usuarios pueden conceder o denegar permisos individuales a una aplicación cuando lo requieran, tales como el acceso a la cámara o el micrófono. Las aplicaciones recuerdan las concesiones de permisos de cada usuario, y pueden ser ajustados en cualquier momento. Sólo las aplicaciones compiladas para Android 6.0 Marshmallow con su SDK utilizarán el nuevo sistema de permisos, mientras que todas las demás aplicaciones continuarán utilizando el modelo de permisos anterior."));

    }

    @Override
    public Android getContact(int id) throws RepositoryErrorException {
        return this.repository.get(id);
    }

    @Override
    public List<Android> getContactsList() throws RepositoryErrorException {
        return new ArrayList<>(this.repository.values());
    }
}
