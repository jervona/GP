package nyc.c4q.assessment;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public interface BaseContract {
    interface BasePresenter<T> {
        void attach(T view);
        void detach();
    }

    interface BaseView{

    }
}
