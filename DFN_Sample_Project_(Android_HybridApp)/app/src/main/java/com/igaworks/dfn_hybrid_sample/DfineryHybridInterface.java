package com.igaworks.dfn_hybrid_sample;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.igaworks.v2.core.AdBrixRm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DfineryHybridInterface {

    Context mContext;

    DfineryHybridInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void purchase (String eventParam) {

        // eventParam 값의 JSON 은 아래와 같이 보낸다고 가정하고 작성한 코드입니다.
        // sample eventParam JSON :
        //{"productList":[
        //  {
        //      "productId":"myproductID1",
        //      "productName":"myProductName",
        //      "price":100000.02,
        //      "discount":90000.02,
        //      "quantity":1
        //  },
        //  {
        //      "productId":"myproductID2",
        //      "productName":"myProductNam2",
        //      "price":200000.02,
        //      "discount":110000.03,
        //      "quantity":1
        //   }
        //   ],
        // "orderId":"myorderId",
        // "orderSale":10000.03,
        // "discount":2000.04,
        // "deliver_charge":1500.05
        // }

        try{

            JSONObject eventparamJson = new JSONObject(eventParam);
            ArrayList<AdBrixRm.CommerceProductModel> productModelArray = new ArrayList<>();
            JSONArray productList = (JSONArray) eventparamJson.get("productList");

            for (int i = 0; i < productList.length(); i++ ) {

                JSONObject product = (JSONObject) productList.get(i);

                AdBrixRm.CommerceProductModel productModel = new AdBrixRm.CommerceProductModel()
                        .setProductID((String) product.get("productId"))
                        .setProductName((String) product.get("productName"))
                        .setPrice((double) product.get("price"))
                        .setDiscount((double) product.get("discount"))
                        .setCurrency(AdBrixRm.Currency.KR_KRW)
                        .setQuantity((int) product.get("quantity"));

                productModelArray.add(productModel);

            }

            // Purchase event call
            AdBrixRm.Common.purchase(
                    (String)eventparamJson.get("orderId"),
                    productModelArray,
                    (double) eventparamJson.get("orderSale"),
                    (double) eventparamJson.get("discount"),
                    (double) eventparamJson.get("deliver_charge"),
                    AdBrixRm.CommercePaymentMethod.CreditCard);

        } catch (NullPointerException | JSONException e) {

            Log.d("peterlog" , "errorLog : " + e.toString());
        }

    }

    @JavascriptInterface
    public void addToCart(String eventParam) {

        // eventParam 값의 JSON 은 아래와 같이 보낸다고 가정하고 작성한 코드입니다.
        // sample eventParam JSON :
        //{"productList":[
        //  {
        //      "productId":"myproductID1",
        //      "productName":"myProductName",
        //      "price":100000.02,
        //      "discount":90000.02,
        //      "quantity":1
        //  },
        //  {
        //      "productId":"myproductID2",
        //      "productName":"myProductNam2",
        //      "price":200000.02,
        //      "discount":110000.03,
        //      "quantity":1
        //   }
        //   ]

        try{

            JSONObject eventparamJson = new JSONObject(eventParam);
            ArrayList<AdBrixRm.CommerceProductModel> productModelArray = new ArrayList<>();
            JSONArray productList = (JSONArray) eventparamJson.get("productList");

            for (int i = 0; i < productList.length(); i++ ) {

                JSONObject product = (JSONObject) productList.get(i);

                AdBrixRm.CommerceProductModel productModel = new AdBrixRm.CommerceProductModel()
                        .setProductID((String) product.get("productId"))
                        .setProductName((String) product.get("productName"))
                        .setPrice((double) product.get("price"))
                        .setDiscount((double) product.get("discount"))
                        .setCurrency(AdBrixRm.Currency.KR_KRW)
                        .setQuantity((int) product.get("quantity"));

                productModelArray.add(productModel);

            }

            // addtocart event call
            AdBrixRm.Commerce.addToCart(productModelArray);

        } catch (NullPointerException | JSONException e) {

            Log.d("peterlog" , "errorLog : " + e.toString());
        }
    }

    @JavascriptInterface
    public void login (String eventParam) {

        // eventParam 값의 JSON 은 아래와 같이 보낸다고 가정하고 작성한 코드입니다.
        // sample eventParam JSON :
        //{
        //  "user_id":"user_id1234",
        // }

        try{

            JSONObject eventparamJson = new JSONObject(eventParam);
            String user_id = (String) eventparamJson.get("user_id");

            // addtocart event call
            AdBrixRm.login(user_id);

        } catch (NullPointerException | JSONException e) {

            Log.d("peterlog" , "errorLog : " + e.toString());
        }

    }

    @JavascriptInterface
    public void signUp (String eventParam) {

        // eventParam 값의 JSON 은 아래와 같이 보낸다고 가정하고 작성한 코드입니다.
        // sample eventParam JSON :
        //{
        //  "sign_up_channel":"kakao",
        // }

        try{

            JSONObject eventparamJson = new JSONObject(eventParam);
            String sign_up_channel = (String) eventparamJson.get("sign_up_channel");

            // SignUp event call
            switch (sign_up_channel){
                case "kakao":
                    AdBrixRm.Common.signUp(AdBrixRm.CommonSignUpChannel.Kakao);
                    break;
                case "google":
                    AdBrixRm.Common.signUp(AdBrixRm.CommonSignUpChannel.Google);
                    break;
                case "naver":
                    AdBrixRm.Common.signUp(AdBrixRm.CommonSignUpChannel.Naver);
                    break;
                case "user_id":
                    AdBrixRm.Common.signUp(AdBrixRm.CommonSignUpChannel.UserId);
                    break;
                default:
                    AdBrixRm.Common.signUp(AdBrixRm.CommonSignUpChannel.ETC);
            }

        } catch (NullPointerException | JSONException e) {

            Log.d("peterlog" , "errorLog : " + e.toString());
        }

    }

    @JavascriptInterface
    public void customEvent (String eventParam) {
        
        // eventParam 값의 JSON 은 아래와 같이 보낸다고 가정하고 작성한 코드입니다.
        // sample eventParam JSON :
        //{
        //  "eventName":"MyCustomEvent",
        //  "attrModel":{
        //      "att1":"attr1_value",
        //      "attr2":100000,
        //      "attr3":3,
        //      "attr4":true
        //   }
        // }

        try{

            JSONObject eventparamJson = new JSONObject(eventParam);
            String eventName = (String) eventparamJson.get("eventName");
            JSONObject attr = (JSONObject) eventparamJson.get("attrModel");

            ArrayList<String> keyList = new ArrayList<>();
            Iterator<String> attrKeys = attr.keys();
            while (attrKeys.hasNext()){
                keyList.add(attrKeys.next());
            }

            AdBrixRm.AttrModel attrModel = new AdBrixRm.AttrModel();

            for (int i=0; i<attr.length(); i++){

                attrModel.setAttrs(keyList.get(i),attr.get(keyList.get(i)));
            }

            //Custom event call
            AdBrixRm.event(eventName, attrModel);

        } catch (NullPointerException | JSONException e) {

            Log.d("peterlog" , "errorLog : " + e.toString());

        }

    }
}
