package com.clean.news.domain.interactor;

import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CORBA.Object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author james on 5/26/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UseCaseTest {

    private UseCaseTestClass useCaseTest;
    private TestDisposableObserver<Object> testDisposableObserver;

    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private PostExecutionThread postExecutionThread;
    @Mock
    private ExpectedException expectedException;

    @Before
    public void setUp() {
        useCaseTest = new UseCaseTestClass(threadExecutor, postExecutionThread);
        testDisposableObserver = new TestDisposableObserver<>();
        given(postExecutionThread.getScheduler()).willReturn(new TestScheduler());
    }

    @Test
    public void executeUseCase_withParamValue_shouldMatch() throws Exception {
        useCaseTest.execute(testDisposableObserver, Params.EMPTY);

        assertThat(testDisposableObserver.valuesCount).isZero();
    }

    @Test
    public void executeUseCase_subscribeWhenExecutingUseCase() throws Exception {
        useCaseTest.execute(testDisposableObserver, Params.EMPTY);
        useCaseTest.dispose();

        assertThat(testDisposableObserver.isDisposed()).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void useCaseExecute_withNullObserver_shouldFail() throws Exception {
        useCaseTest.execute(null, Params.EMPTY);
    }

    private static class UseCaseTestClass extends UseCase<Object, Params> {

        UseCaseTestClass(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
            super(threadExecutor, postExecutionThread);
        }

        @Override
        public Observable<Object> buildUseCaseObservable(Params params) {
            return Observable.empty();
        }

        @Override
        public void execute(DisposableObserver<Object> observer, Params params) {
            super.execute(observer, params);
        }
    }

    private static class TestDisposableObserver<T> extends DisposableObserver<T> {
        private int valuesCount = 0;

        @Override
        public void onNext(T value) {
            valuesCount++;
        }

        @Override
        public void onError(Throwable e) {
            // no-op by default.
        }

        @Override
        public void onComplete() {
            // no-op by default.
        }
    }


    private static class Params {
        private static Params EMPTY = new Params();

        private Params() {
        }
    }

}