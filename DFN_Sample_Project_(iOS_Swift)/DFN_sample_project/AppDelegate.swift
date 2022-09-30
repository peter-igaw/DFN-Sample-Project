//
//  AppDelegate.swift
//  DFN_sample_project
//
//  Created by Jin-uk Park on 2022/08/09.
//

import UIKit
import AdBrixRmKit

@main
class AppDelegate: UIResponder, UIApplicationDelegate {



    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        // Create AdBrixRM Instance
            let adBrix = AdBrixRM.getInstance

            // Set adbrix appKey & secretKey
            adBrix.initAdBrix(appKey: "your_app_key", secretKey: "your_secret_key")
        

        return true
    }
    
    func application(_ app: UIApplication, open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:]) -> Bool {
        // Create AdBrixRM Instance
        let adBrix = AdBrixRM.getInstance

        // Add Deep Link Open Tracking Code
        adBrix.deepLinkOpen(url: url)

        return false
    }

    // MARK: UISceneSession Lifecycle

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }

    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }


}

