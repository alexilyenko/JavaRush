package com.javarush.test.level26.lesson05.task03;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Тот, кто любит труд, не нуждается в развлечениях.
Расставьте volatile там, где необходимо
*/
public class Solution {
    private final URL javarushUrl;
    private final URL javarushUrl1Child;
    private final URL javarushVkGroupUrl;
    private final URL javarushVkGroupUrl1Child;
    private final URL javarushVkGroupUrl2Child;
    private final URL javarushVkGroupUrl3Child;

    private volatile ExecutorService executorService;
    private final Set<URL> urlsForProcessing = new HashSet();

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Solution solution = new Solution();
        solution.start();
        Thread.sleep(1000);
        solution.stop();
    }

    public Solution() throws MalformedURLException {
        javarushUrl = new URL("http://javarush.ru/");
        javarushVkGroupUrl = new URL("http://vk.com/javarush");
        javarushUrl1Child = new URL("http://info.javarush.ru/page/FAQ/");
        javarushVkGroupUrl1Child = new URL("https://plus.google.com/114772402300089087607/about");
        javarushVkGroupUrl2Child = new URL("https://www.facebook.com/pages/Javarush/524321077686033");
        javarushVkGroupUrl3Child = new URL("https://twitter.com/javarush_ru");

        urlsForProcessing.add(javarushUrl);
        urlsForProcessing.add(javarushVkGroupUrl);
    }

    public synchronized void start() {
        executorService = Executors.newCachedThreadPool();
        for (URL url : urlsForProcessing) {
            submitUrlTask(url);
        }
        urlsForProcessing.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUnprocessedUrls(executorService.shutdownNow());
            if (executorService.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                saveUnprocessedUrls(getCancelledTasksFromExecutor());
            }
        } finally {
            executorService = null;
        }
    }

    private List<Runnable> getCancelledTasksFromExecutor() {
        return Collections.EMPTY_LIST;
    }

    protected List<URL> processPage(URL url) {
        System.out.println(url + " will be processed");
        return getChildUrlByParent(url);
    }

    private List<URL> getChildUrlByParent(URL url) {
        List<URL> result = new ArrayList<>();

        if (javarushUrl.equals(url)) {
            result.add(javarushUrl1Child);
        } else if (javarushVkGroupUrl.equals(url)) {
            result.add(javarushVkGroupUrl1Child);
            result.add(javarushVkGroupUrl2Child);
            result.add(javarushVkGroupUrl3Child);
        }
        return result;
    }

    private void saveUnprocessedUrls(List<Runnable> unprocessed) {
        for (Runnable task : unprocessed) {
            urlsForProcessing.add(((UrlTask) task).getPage());
        }
    }

    private void submitUrlTask(URL url) {
        executorService.execute(new UrlTask(url));
    }

    public class UrlTask implements Runnable {
        private final URL url;

        private UrlTask(URL url) {
            this.url = url;
        }

        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) return;
                submitUrlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}
