//
//  ViewController.swift
//  DFN_sample_project
//
//  Created by Jin-uk Park on 2022/08/09.
//

import UIKit
import AdBrixRmKit
import AppTrackingTransparency

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    override func viewDidAppear(_ animated: Bool) {
          
        let adBrix = AdBrixRM.getInstance
        
        
        // IDFA Authorize (Optional)
        
        if #available(iOS 14, *) {
          ATTrackingManager.requestTrackingAuthorization {(status) in
            switch status{
            case.authorized:
              adBrix.startGettingIDFA()
            case.denied:
              adBrix.stopGettingIDFA()
            case.notDetermined :
              adBrix.stopGettingIDFA()
            case.restricted:
              adBrix.stopGettingIDFA()
            default:
              adBrix.stopGettingIDFA()
            }
          }
        }
      }

    @IBAction func eventAttr(_ sender: Any) {
        
        let adbrix = AdBrixRM.getInstance
        
        let attrModel = AdBrixRmAttrModel()
        attrModel.setAttrDataString("your_key", "your_value")
        
        // event with extra info
        adbrix.eventWithAttr(eventName: "your_event_name", value: attrModel)
        
    }
    
    @IBAction func event(_ sender: Any) {
        
        let adrix = AdBrixRM.getInstance
        
        // event name only
        adrix.event(eventName: "your_event_name")
        
    }
}

