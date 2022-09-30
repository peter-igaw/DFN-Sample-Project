//
//  AppDelegate.m
//  DFNSampleProject
//
//  Created by Jin-uk Park on 2022/07/22.
//

#import "AppDelegate.h"
#import <AdBrixRmKit/AdBrixRmKit.h>


@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
    
    // Create AdBrixRM Instance
        AdBrixRM *adBrix = [AdBrixRM sharedInstance];

        // Set adbrix appKey & secretKey
        [adBrix initAdBrixWithAppKey:@"odhvASVRDsdf10d019fva" secretKey:@"ar98LszQZUGdmSznToNBXg"];

    return YES;
}


- (BOOL)application:(UIApplication *)app openURL:(NSURL *)url options:(NSDictionary *)options
{
    // Create AdBrixRM Instance
    AdBrixRM *adBrix = [AdBrixRM sharedInstance];

    // Add Deep Link Open Tracking Code
    [adBrix deepLinkOpenWithUrl:url];

    return YES;

}


#pragma mark - UISceneSession lifecycle


- (UISceneConfiguration *)application:(UIApplication *)application configurationForConnectingSceneSession:(UISceneSession *)connectingSceneSession options:(UISceneConnectionOptions *)options {
    // Called when a new scene session is being created.
    // Use this method to select a configuration to create the new scene with.
    return [[UISceneConfiguration alloc] initWithName:@"Default Configuration" sessionRole:connectingSceneSession.role];
}


- (void)application:(UIApplication *)application didDiscardSceneSessions:(NSSet<UISceneSession *> *)sceneSessions {
    // Called when the user discards a scene session.
    // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
    // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
}



@end
