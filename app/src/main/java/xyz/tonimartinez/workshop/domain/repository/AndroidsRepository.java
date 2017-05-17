package xyz.tonimartinez.workshop.domain.repository;

import java.util.List;

import xyz.tonimartinez.workshop.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.workshop.domain.model.Android;

/**
 * Created by tonimc on 5/17/17.
 */
public interface AndroidsRepository {
    Android getContact(int id) throws RepositoryErrorException;
    List<Android> getContactsList() throws RepositoryErrorException;
}
