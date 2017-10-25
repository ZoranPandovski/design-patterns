#import "Singleton.h"

@implementation Singleton

// The shared and only instance
static Singleton *__instance;

+ (instancetype)sharedInstance {
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        __instance = [[self alloc] init];
    });
    return __instance;
}

#pragma mark - Lifecycle

// Prevent allocation of other instances
+ (instancetype)allocWithZone:(struct _NSZone *)zone {
    if (__instance) {
        return [self sharedInstance];
    }
    return [super allocWithZone:zone];
}

#pragma mark - NSCopying

- (id)copyWithZone:(NSZone *)zone {
    return [self.class sharedInstance];
}

@end
