//
//  ViewController.m
//  DFNSampleProject
//
//  Created by Jin-uk Park on 2022/07/22.
//

#import "ViewController.h"
#import <AdBrixRmKit/AdBrixRmKit.h>


@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (IBAction)account_created_start:(id)sender {
    
    AdBrixRM *adBrix = [AdBrixRM sharedInstance];
    
    [adBrix eventWithEventName:@"accountCreatedStart"];

}

- (IBAction)account_created_complete:(id)sender {
    
    AdBrixRM *adBrix = [AdBrixRM sharedInstance];

    [adBrix eventWithEventName:@"accountCreatedComplete"];

}


@end
