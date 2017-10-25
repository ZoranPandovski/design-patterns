#import <Foundation/Foundation.h>

@interface Singleton : NSObject <NSCopying>

+ (instancetype)sharedInstance;

@end
