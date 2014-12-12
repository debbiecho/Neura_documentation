//
//  Neura.h
//  Neura
//
//  Created by MIchael on 12/4/14.
//  Copyright (c) 2014 Neura. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface Neura : NSObject

+ (Neura *)sharedInstance;

@property (atomic,strong) NSString* clientId;
@property (atomic,strong) NSString* clientSecretId;
@property (atomic,strong) NSString* permmisions;

- (void)AuthenticationWithError:(NSError **)error;

@end
