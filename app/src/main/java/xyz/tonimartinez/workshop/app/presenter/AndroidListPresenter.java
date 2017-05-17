package xyz.tonimartinez.workshop.app.presenter;

import xyz.tonimartinez.workshop.app.activity.MainActivity;
import xyz.tonimartinez.workshop.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.workshop.domain.repository.AndroidsRepository;
import xyz.tonimartinez.workshop.domain.repository.AndroidsRepositoryImpl;

/**
 * Created by tonimc on 5/17/17.
 */

public class AndroidListPresenter {

    private MainActivity view;

    private AndroidsRepository androidsRepository;

    public AndroidListPresenter(MainActivity view) {
        this.view = view;
        this.androidsRepository = new AndroidsRepositoryImpl();
    }

    public void getAndroidList() {
        view.showLoading();
        try {
            view.renderAndroidList(this.androidsRepository.getContactsList());
        } catch (RepositoryErrorException e) {
            view.showError(e.getMessage());
        }
    }
}
