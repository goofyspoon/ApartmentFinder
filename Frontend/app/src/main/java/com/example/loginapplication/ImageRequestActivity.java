//package com.example.loginapplication;
//
//import com.android.volley.toolbox.ImageLoader;
//import com.example.loginapplication.app.AppController;
//import com.example.loginapplication.net_utils.Const;
//
//public class ImageRequestActivity {
//    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
//
//    //If you are using NetworkImageView
//    imgNetWorkView.setImageUrl(Const.URL_IMAGE, imageLoader);
//
//    ImageLoader imageLoader = AppController.getinstance().getImageLoader();
//
//    //If you are using normal ImageView
//    imageLoader.get(Const.URL_IMAGE, new ImageListener(){
//        @Override
//        public void onErrorResponse(VolleyError error){
//            Log.e(TAG, "Image Load Error: "+ error.getMessage());
//        }
//
//        @Override
//        public void onResponse(ImageContainer response, boolean arg1){
//            if(response.getBitmap() != null){
//                //Load Image into imageview
//                imageView.setImageBitmap(response.getBitmap());
//            }
//        }
//    });
//
//    //Loading image with placeholder and error image, need to add image files under drawable folder
//    imageLoader.get(Const.URL_IMAGE, ImageLoader.getImageListener(imageView, R.drawable.ico_loading, R.drawable.ico_error));
//}
