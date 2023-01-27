package com.example.remenberwhenalbum;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyImagesRepository {
    private MyImagesDao myImagesDao;
    private LiveData<List<MyImages>>imagesList;

    public MyImagesRepository(Application application){

        MyImagesDatabase database = MyImagesDatabase.getInstance(application);
        myImagesDao = database.myImagesDao();
        imagesList  = myImagesDao.getAllImages();

    }
        public void insert(MyImages myImages)
        {
        new InsertImageAsyncTask(myImagesDao).execute(myImages);
            }
        public void delete(MyImages myImages)
         {
        new DeleteImageAsyncTask(myImagesDao).execute(myImages);
             }
         public void update(MyImages myImages)
         {
             new UpdateImageAsyncTask(myImagesDao).execute(myImages);
             }
             public LiveData<List<MyImages>>getAllImages(){
            return imagesList;
             }
             private static class InsertImageAsyncTask extends AsyncTask<MyImages,Void ,Void> {

            MyImagesDao imagesDao;
            public InsertImageAsyncTask(MyImagesDao imagesDao){
                this.imagesDao = imagesDao;

            }

                 @Override
                 protected Void doInBackground(MyImages... myImages) {
                     imagesDao.insert(myImages[0]);

                     return null;
                 }
             }

    private static class UpdateImageAsyncTask extends AsyncTask<MyImages,Void ,Void> {

        MyImagesDao imagesDao;
        public UpdateImageAsyncTask(MyImagesDao imagesDao){
            this.imagesDao = imagesDao;

        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDao.update(myImages[0]);

            return null;
        }
    }

    private static class DeleteImageAsyncTask extends AsyncTask<MyImages,Void ,Void> {

        MyImagesDao imagesDao;
        public DeleteImageAsyncTask(MyImagesDao imagesDao){
            this.imagesDao = imagesDao;

        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDao.Delete(myImages[0]);

            return null;
        }
    }
}
