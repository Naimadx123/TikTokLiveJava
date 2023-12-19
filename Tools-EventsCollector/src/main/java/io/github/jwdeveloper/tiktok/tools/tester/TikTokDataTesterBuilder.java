/*
 * Copyright (c) 2023-2023 jwdeveloper jacekwoln@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.jwdeveloper.tiktok.tools.tester;

import io.github.jwdeveloper.tiktok.live.builder.LiveClientBuilder;
import io.github.jwdeveloper.tiktok.tools.tester.api.DataTester;
import io.github.jwdeveloper.tiktok.tools.tester.api.DataTesterBuilder;
import io.github.jwdeveloper.tiktok.tools.tester.api.DataTesterModel;

import java.util.function.Consumer;

public class TikTokDataTesterBuilder implements DataTesterBuilder {
    private final DataTesterModel model;

    public TikTokDataTesterBuilder(String databaseName) {
        this.model = new DataTesterModel();
        this.model.setDatabaseName(databaseName);
    }

    @Override
    public DataTesterBuilder setSessionTag(String sessionTag) {
        model.setSessionTag(sessionTag);
        return this;
    }

    @Override
    public DataTesterBuilder setUser(String user) {
        model.setUser(user);
        return this;
    }

    @Override
    public DataTesterBuilder configureLiveClient(Consumer<LiveClientBuilder> builderConsumer) {
        model.setBuilderConsumer(builderConsumer);
        return this;
    }

    @Override
    public DataTester build() {
        return new TikTokDataTester(model);
    }

    @Override
    public DataTester buildAndRun()
    {
        var tester = build();
        tester.connect();
        return tester;
    }
}