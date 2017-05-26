/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clean.news.dagger.components;

import android.content.Context;
import com.clean.news.dagger.modules.NetworkModule;
import com.clean.news.view.navigator.DemoAppNavigator;
import com.clean.news.view.splashscreen.SplashScreenActivity;
import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import com.clean.news.domain.repository.NewsRepository;
import com.clean.news.domain.repository.NewsSourcesRepository;
import com.clean.news.dagger.modules.ApplicationModule;
import com.clean.news.view.BaseActivity;
import com.clean.news.view.newslist.NewsListActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    NewsRepository newsRepository();

    NewsSourcesRepository newsSourcesRepository();

    //where
    void inject(BaseActivity baseActivity);

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(NewsListActivity newsListActivity);

    void inject(DemoAppNavigator activityNavigator);
}